pipeline{
	agent any
	def url = readProperties file: 'PropertiesFile.properties'
	stages{
		stage('checkout') { 
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
	steps{
	script {
		def server = Artifactory.newServer url:url.ARTIFACTORY_ID, username: url.username, password: url.password
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
