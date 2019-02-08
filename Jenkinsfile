pipeline{
	agent any
	stages{
		stage('checkout') { 			
		steps{
			script{	
				def url = readProperties file: 'PropertiesFile.properties'
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
	steps{
	script {
		echo "${Artifactoryurl.ARTIFACTORY_ID}"
		def server = Artifactory.newServer url:'http://localhost:8081/artifactory', username: 'admin', password: 'password'
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
