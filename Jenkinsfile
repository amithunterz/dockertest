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
						
						bat 'docker tag $registry:$BUILD_NUMBER $registry:$BUILD_NUMBER'
						bat 'docker push $registry:$BUILD_NUMBER'
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