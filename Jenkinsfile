pipeline{
	agent any
	stages{
stage('checkout') { 
	steps{
		script{
	def xxx = readProperties file: 'PropertiesFile.properties'
	echo xxx.username;
	}
	}
}
	}
}
