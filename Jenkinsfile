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
		
		

		
		
		
		stage('docker run') 
		{
			steps
			{				
				bat "docker run -d --rm -p 8087:8080 --name dockerdemo asramitsinghrawat/dockerdemo:27"						
			}
		}
		
		
		
		stage('docker stop') 
		{
			
			input {
                message "Proceed to stop the container"
                ok "Yes, Stop it"
                
            }
			
			steps
			{
				bat "docker stop dockerdemo"
			}
		}
		
		stage('docker remove image') 
		{
			steps
			{
				bat "docker rmi asramitsinghrawat/dockerdemo:27"
			}
		}		
	
	}
}