node('master'){
checkout scm;
def xxx = readProperties file: 'PropertiesFile.properties'
stage('checkout') { 
	echo xxx.username;
}
}
