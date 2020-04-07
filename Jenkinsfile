pipeline
{
	agent any	
	stages
	{
		stage('docker build')
		{
			steps{
			docker.build("asramitsinghrawat/dockerdemo")
			}
		}

		stage('docker push')
		{
			steps
			{
				docker.withRegistry('https://registry.hub.docker.com','docker-hub')
				push("${env.BUILD_NUMBER}")
				push("latest")
			}
		}
	}
}