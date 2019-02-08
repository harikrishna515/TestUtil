node('master'){
stage('git checkout') {
git 'https://github.com/harikrishna515/DevOps-301Training.git'
}  
stage('Build & Compile') {    
sh 'mvn clean package'
}
stage ('SonarQube Analysis'){
sh 'mvn sonar:sonar'
}
stage ('Artifactory Deploy'){
script {
def server = Artifactory.newServer url: 'http://localhost:8081/artifactory', username: 'admin', password: 'password'
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
	sh 'sudo cp target/*.war /home/devopsuser4/apache-tomcat-8.5.37/webapps'
	sh 'sudo ls -ltr /home/devopsuser4/apache-tomcat-8.5.37/webapps
}
}