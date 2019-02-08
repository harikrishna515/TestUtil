node('master'){
checkout scm;
def url =readFile "PropertiesFile.properties"
stage('checkout') { 
	echo "${url}"
	//def Var1= url.GIT_URL
	//echo "Var1=${Var1}"
	git url.GIT_URL
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
