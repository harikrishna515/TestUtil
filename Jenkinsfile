node('master'){
checkout scm;
def url =readFile "PropertiesFile.properties"
stage('checkout') { 
	echo url.AppRepURL;
}
}
