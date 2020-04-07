pipeline
{
	environment 
	{
		registry = 'asramitsinghrawat/dockerdemo'
		registryCredential = 'docker-hub'
		dockerImage = ''
	}
	
	agent any
	
	stages
	{		
		
		stage('docker build') 
		{
			steps
			{
				script 
				{
					dockerImage = docker.build registry + ":$BUILD_NUMBER"
				}
			}
		}

		
		stage('docker push') 
		{
			steps
			{
				script 
				{
					docker.withRegistry( '', registryCredential ) 
					{
						dockerImage.push()
					}
				}
			}
		}
		
		stage('docker remove image') 
		{
			steps
			{
				bat "docker rmi $registry:$BUILD_NUMBER"
			}
		}		
		
	}
}