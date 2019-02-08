pipeline{
	agent any
	stages{
		stage('checkout') { 
			def url = readProperties file: 'PropertiesFile.properties'
		steps{
			script{				
			echo "${url.GIT_URL}"
				def Var1= url.GIT_URL
				echo "Var1=${Var1}"
				git "${Var1}"
			}
		}
	}
	stage('Build & Compile') { 
		steps{
		sh 'mvn clean package'
		}
	}
		stage ('SonarQube Analysis'){
	steps{
		sh 'mvn sonar:sonar'
		}
	}
		stage ('Artifactory Deploy'){
			def url1 = readProperties file: 'PropertiesFile.properties'
	steps{
	script {
		def server = Artifactory.newServer url:url1.ARTIFACTORY_ID, username: url1.username, password: url1.password
		def uploadSpec = """{
		  "files": [
			{
			  "pattern": "*.war",
			  "target": "lib-staging"
			}
		 ]
		}"""
			}	
		}
}
	}	
}
