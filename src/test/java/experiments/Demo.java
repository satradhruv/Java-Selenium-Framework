package experiments;

import java.util.Date;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
//		String dateText= date.toString();
//		String dateTextWithoutSpaces= dateText.replace("", "_");
//		String dateTextWithoutSpacesAndColn= dateText.replace(":", "_");
//		System.out.println(dateTextWithoutSpacesAndColn);
		System.out.println(date.toString().replace(" ", "_").replace(":", "_"));

	}

}
