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
				bat "docker build -t asramitsinghrawat/dockerdemo:$BUILD_NUMBER ."			
			}
		}

		
		stage('docker push') 
		{
			steps
			{
				
				bat "docker push asramitsinghrawat/dockerdemo:$BUILD_NUMBER"
					
			}
		}
		
		stage('docker remove image') 
		{
			steps
			{
				bat "docker rmi asramitsinghrawat/dockerdemo:$BUILD_NUMBER"
			}
		}		
	
	}
}