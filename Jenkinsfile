node('master'){
checkout scm;
def url =readFile "PropertiesFile.properties"
stage('checkout') { 
	echo "${url}"
	def Var1= 'https://github.com/harikrishna515/DevOps-301Training.git'
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
def server = Artifactory.newServer url.ARTIFACTORY_ID,url.username,url.password
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
