pipeline{
	agent any
	stages{
stage('checkout') { 
	steps{
		script{
	xxx = readProperties file: 'PropertiesFile.properties'
	echo xxx.username;
	}
	}
}
	}
}
