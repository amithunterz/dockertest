pipeline
{
	environment 
	{
		registry = 'asramitsinghrawat/dockerdemo'
		registryCredential = 'docker-hub'
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
		
		stage('docker run') 
		{
			steps
			{
				
				bat "docker run -d --rm -p 8087:8080 --name dockerdemo asramitsinghrawat/dockerdemo:$BUILD_NUMBER"						
			}
		}
		
		stage('docker stop') 
		{
			steps
			{
				bat "docker stop dockerdemo"
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