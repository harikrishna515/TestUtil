node('master') {
	stage('git checkout') {
		checkout scm;
			def url =readProperties file: 'PropertiesFile.propertie
		   echo "${url.username}"
			def Var1= url.GIT_URL
			echo "Var1=${Var1}"
			git "${Var1}"
		}    
}
