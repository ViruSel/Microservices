package org.firebasecrud;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class FirebaseCrudApplication {

	public static void main(String[] args) throws IOException
	{
		File file = new File("./serviceAccountKey.json");
		FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
						.setDatabaseUrl("https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-ie8pb%40fir-crud-main-892ed.iam.gserviceaccount.com")
								.build();

		FirebaseApp.initializeApp(options);

		SpringApplication.run(FirebaseCrudApplication.class, args);
	}

}
