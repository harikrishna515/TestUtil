pipeline{
	agent any
	stages{
checkout scm;
def url =readProperties file: 'PropertiesFile.properties'
stage('checkout') { 
	echo "${url}"
	def Var1= url.GIT_URL
	echo "After variable def"
	echo "Var1=${Var1}"
	echo "===================="
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
def server = Artifactory.newServer url: url.ARTIFACTORY_ID, username: url.username, password: url.password
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
	sh 'sudo cp target/*.war url.DeploymentPath'
	sh 'sudo ls -ltr url.DeploymentPath'
}
}
}
