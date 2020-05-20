import java.io.File;

class ReturnAllParents {

	static File path;
	static StringBuilder result;

	public ReturnAllParents() {
		this.path = new File(
				"/Users/brentleytrucker/Desktop/misc/Portfolio/InterviewPreparation/InterviewPreparation/Recursion/src/Recursion.java");
		this.result = new StringBuilder();
	}

	public static void main(String args[]) {
		ReturnAllParents ret = new ReturnAllParents();
		recurse();
	}

	public static void recurse() {

		while (path.getParent() != null) {
			result.append(path.getName() + (char) 92);
			File newFile = new File(path.getParent());
			path = newFile;
		}
		if (path.getParent() == null) {
			System.out.println(result.toString());
		}

	}
}
