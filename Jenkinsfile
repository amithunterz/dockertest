pipeline
{
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
				withDockerRegistry(credentialsId: 'docker-hub', url: 'https://registry.hub.docker.com'){
				
				bat 'docker push asramitsinghrawat/dockerdemo'
				
				}
			}
		}
	}
}