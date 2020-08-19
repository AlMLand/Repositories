package swing.youtube.tachenrechner.one.one;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImagesURLImport {

	private static final String[] ARRAY_SUFFIX = { "Plus.png", "Minus.png", "Multiply.png", "Divide.png",
			"Result.png" };

	private static final List<URL> LIST_URL_ADRESSE = new ArrayList<URL>();

	private static File file = new File(System.getProperty("java.io.tmpdir") + "//MyDirectoryCalculatorGitHub1985//");

	static {
		if (!file.exists()) {
			try {
				LIST_URL_ADRESSE.add(new URL("https://img.icons8.com/material-rounded/50/000000/plus-2-math--v1.png"));
				LIST_URL_ADRESSE
						.add(new URL("https://img.icons8.com/material-rounded/24/000000/filled-minus-2-math.png"));
				LIST_URL_ADRESSE.add(new URL("https://img.icons8.com/material-rounded/24/000000/multiply-2.png"));
				LIST_URL_ADRESSE.add(new URL("https://img.icons8.com/material-rounded/24/000000/divide-2.png"));
				LIST_URL_ADRESSE.add(new URL("https://img.icons8.com/material-rounded/24/000000/equal-sign-2.png"));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

			if (!file.exists()) {
				file.mkdir();
			}

			for (int i = 0; i < LIST_URL_ADRESSE.size(); i++) {
				try (InputStream inputStream = LIST_URL_ADRESSE.get(i).openStream()) {
					Files.copy(inputStream, Paths.get(file + "//" + ARRAY_SUFFIX[i]),
							StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
	}

	public static File getFile() {
		return file;
	}

	public static void setFile(File file) {
		ImagesURLImport.file = file;
	}

	public static String[] getArraysuffix() {
		String[] array = Arrays.copyOf(ARRAY_SUFFIX, ARRAY_SUFFIX.length);
		return array;
	}

	public static List<URL> getListurl() {
		return new ArrayList<URL>(LIST_URL_ADRESSE);
	}

}
