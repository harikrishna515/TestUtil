pipeline{
	agent any
	stages{
stage('checkout') { 
	steps{
		script{
	def xxx = readFile 'PropertiesFile.properties'
	echo xxx.username;
	}
	}
}
	}
}
