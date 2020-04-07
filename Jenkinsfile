pipeline
{
	environment {
 registry = 'asramitsinghrawat/dockerdemo'
 registryCredential = 'docker-hub'
 
}
	agent any	
	stages
	{
		stage('docker build')
		{
			steps{
			bat 'docker build -t asramitsinghrawat/dockerdemo .'
			}
		}

		stage('docker push')
		{
			steps
			{
				withDockerRegistry(credentialsId: registryCredential, url: 'https://registry.hub.docker.com'){
				
				Image.push(asramitsinghrawat/dockerdemo)
				
				}
			}
		}
	}
}