pipeline{
	agent any
	stages{
stage('checkout') { 
	steps{
		script{
	xxx = readProperties file: 'PropertiesFile.properties'
	echo "${url.GIT_URL}"
	def Var1= url.GIT_URL
	echo "Var1=${Var1}"
	git "${Var1}"
	}
	}
}
	}
}
