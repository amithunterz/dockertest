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
				withDockerRegistry(credentialsId: 'docker-hub', toolName: 'Docker_19_03_8', url: 'https://registry.hub.docker.com'){
				
				push("${env.BUILD_NUMBER}")
				push("latest")
				
				}
			}
		}
	}
}