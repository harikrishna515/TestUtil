node('master') {
  notify('Project Build Started')
	stage('git checkout') {
		checkout scm;
		   checkout scm;
			def url =readFile "PropertiesFile.properties"
		   echo "${url.GIT_URL}"
			def Var1= url.GIT_URL
			echo "Var1=${Var1}"
			git "${Var1}"
		}    
}
