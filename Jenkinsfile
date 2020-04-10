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
                message "Should we continue?"
                ok "Yes, we should."
                submitter "alice,bob"
                parameters {
                    string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
                }
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