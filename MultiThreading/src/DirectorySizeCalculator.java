import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Calculates the total number of files and bytes found in one or more
 * directories, and their subdirectories. Accumulates results.
 *
 * Used to demonstrate multithreading and how to use a work queue.
 *
 * @see DirectorySizeCalculator
 * @see MultithreadedDirectorySizeCalculator
 */
public class DirectorySizeCalculator {


	private long files;
	private long bytes;

	/**
	 * Initializes the number of files found and total bytes found to 0.
	 */
	public DirectorySizeCalculator() {
		this.files = 0;
		this.bytes = 0;
	}

	/**
	 * Resets the counters, allowing this object to be easily reused if desired.
	 */
	public void reset() {
		this.bytes = 0;
		this.files = 0;

	}

	/**
	 * Returns the number of files found since the last reset.
	 *
	 * @return number of files
	 */
	public long files() {

		return this.files;
	}

	/**
	 * Returns the number of bytes found since the last reset.
	 *
	 * @return number of bytes
	 */
	public long bytes() {

		return this.bytes;
	}

	/**
	 * Adds the number of files and bytes in the specified path to the current
	 * total.
	 *
	 * @param path
	 */
	public void addPath(Path path) {
		try {
			if (Files.isDirectory(path)) {
				processDirectory(path);
			}
			else if (Files.exists(path)) {
				updateCounters(1, Files.size(path));
			}
		}
		catch (IOException e) {
			System.out.println("IOException = "+e);
		}
	}

	/**
	 * Handles per-directory parsing. If a subdirectory is encountered, a
	 * recursive call will handle that subdirectory.
	 */
	private void processDirectory(Path directory) {
		assert Files.isDirectory(directory);


		try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
			for (Path path : stream) {
				// looks familiar, right? we could call addDirectory(path)
				// but lets keep this as-is because it will be helpful for
				// multithreading
				if (Files.isDirectory(path)) {
					processDirectory(path);
				}
				else {
					updateCounters(1, Files.size(path));
				}
			}
		}
		catch (IOException e) {
			System.out.println("IOException = "+e);
		}
	}

	/**
	 * Updates the number of files and bytes found. Not entirely necessary for
	 * this example, but becomes useful when we move to multithreading.
	 *
	 * @param files
	 * @param bytes
	 */
	private void updateCounters(long files, long bytes) {
		assert files >= 0;
		assert bytes >= 0;

		this.files += files;
		this.bytes += bytes;
	}

	/**
	 * Runs a simple example to demonstrate this class. Try changing the path to
	 * your root directory, and see how long it takes!
	 *
	 * @param args
	 *            unused
	 */
	public static void main(String[] args) {
		DirectorySizeCalculator demo = new DirectorySizeCalculator();
		demo.addPath(Paths.get("."));

		System.out.println(demo.files() + " files");
		System.out.println(demo.bytes() + " bytes");
	}
}
