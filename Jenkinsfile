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
		
		stage('docker remove image') 
		{
			steps
			{
				bat "docker rmi asramitsinghrawat/dockerdemo:$BUILD_NUMBER"
			}
		}
		
		stage('docker pull') 
		{
			steps
			{
				
				bat "docker pull asramitsinghrawat/dockerdemo:$BUILD_NUMBER"
					
			}
		}
		
		stage('docker run') 
		{
			steps
			{
				
				bat "docker run -d --rm -p 8087:8080 --name dockerdemo asramitsinghrawat/dockerdemo:$BUILD_NUMBER"
					
			}
		}

		
	
	}
}