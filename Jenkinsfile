node('master'){
checkout scm;
def url =readFile "PropertiesFile.properties"
stage('checkout') { 
	echo "${url.GIT_URL}"
	def Var1= url.GIT_URL
	echo "Var1=${Var1}"
	git "${Var1}"
}
stage('Build & Compile') {    
	sh 'mvn clean package'
}
stage ('SonarQube Analysis'){
sh 'mvn sonar:sonar'
}
stage ('Artifactory Deploy'){
script {
def server = Artifactory.newServer url:'http://localhost:8081/artifactory', username: 'admin', password: 'password'
def uploadSpec = """{
  "files": [
    {
      "pattern": "*.war",
      "target": "lib-staging"
    }
 ]
}"""
server.upload(uploadSpec)
}
}
stage ('Deploy')
{
	sh 'sudo cp target/*.war ' + url.DeploymentPath
	sh 'sudo ls -ltr ' + url.DeploymentPath
}
}
