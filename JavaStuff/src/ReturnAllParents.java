import java.io.File;

class ReturnAllParents {

	static File file;
	static StringBuilder result;

	public ReturnAllParents() {
		this.file = new File(
				"/Users/brentleytrucker/Desktop/misc/Portfolio/InterviewPreparation/InterviewPreparation/Recursion/src/Recursion.java");
		this.result = new StringBuilder();
	}

	public static void main(String args[]) {
		ReturnAllParents ret = new ReturnAllParents();
		recurse();
	}

	public static void recurse() {

		while (file.getParent() != null) {
			result.append(file.getName() + (char) 92);
			File newFile = new File(file.getParent());
			file = newFile;
		}
		if (file.getParent() == null) {
			System.out.println(result.toString());
		}

	}
}
