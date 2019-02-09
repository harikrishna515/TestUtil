pipeline{
	agent any
	stages{
		stage('checkout') { 			
		steps{
			script{	
				sh 'mkdir properties;cd properties'
				git 'https://github.com/harikrishna515/TestUtil'
				def url = readProperties file: 'PropertiesFile.properties'
				echo "${url.GIT_URL}"
				def Var1= url.GIT_URL
				echo "Var1=${Var1}"
				sh 'cd ..'
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
		sh 'cd properties'
		def url = readProperties file: 'PropertiesFile.properties'
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
	stage ('Deploy')
{
steps{
	sh 'sudo cp target/*.war /home/devopsuser4/apache-tomcat-8.5.37/webapps'
	sh 'sudo ls -ltr /home/devopsuser4/apache-tomcat-8.5.37/webapps'
	}
}	

}
}
