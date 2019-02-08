node {
       checkout scm;
       def url =readProperties file: 'properties_file.properties'
       stage('checkout') { 
                    echo "${url}"
                    def Var1= url.GIT_URL
                    //echo "Var1=${Var1}"
                    git "${Var1}"
                }
        stage('Build') {
          sh "mvn clean install" 
            }
        stage('SonarQube analysis') { 
         sh 'mvn sonar:sonar' 
           }
	   
        stage ('deploying artifact'){
          sh 'cd target';
          sh 'pwd';
          sh 'ls -a';
	  def server = Artifactory.newServer url: url.ARTIFACTORY_ID, username: url.username, password: url.password;
	  def uploadSpec="""{
	       "files":[
		  {
		  "pattern": "*.war",
		"target": "lib-staging"
		  }
		]
	  }"""
	 server.upload(uploadSpec)

	}
	stage("Deploy"){
		sh 'sudo cp target/*.war ' + url.DeploymentPath
		sh 'sudo ls -ltr ' + url.DeploymentPath
	}
		
	stage('confirmation for build')

	{

	input message:'Do you want to send it to production?',ok:'YES'

	}


}
