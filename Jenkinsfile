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
						
						bat "docker run -d --rm -p 8087:8080 --name dockerdemo asramitsinghrawat/dockerdemo:51"	
					}
				}
				
				
				stage('docker stop and remove image') 
				{
					input {
						notify('Paused')
						message "Proceed to stop the container and remove image"
						ok "Yes, Stop it"
					}
					
					steps
					{
						bat "docker stop dockerdemo"
						bat "docker rmi asramitsinghrawat/dockerdemo:51"
					}
				}
	}

	post
	{
		success
		{
			notify('succeeded')
		}
		failure
		{
			notify('error')
		}
	}


}

def notify(status)
{
	emailext(to: "amitsinghrawat@gmail.com",
	subject: "${status}: Job '${env.JOB_NAME}[${env.BUILD_NUMBER}]'",
	body:"""${status}: Job '${env.JOB_NAME}[${env.BUILD_NUMBER}]':
Check Console Output at ${env.BUILD_URL}"""
	)
}