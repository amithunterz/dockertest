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
						notify('started')
						bat "dock build -t asramitsinghrawat/dockerdemo:$BUILD_NUMBER ."			
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
						notify('Paused')
					}
				}
				
				
				stage('docker stop and remove image') 
				{
					input {
						message "Proceed to stop the container and remove image"
						ok "Yes, Stop it"
					}
					
					steps
					{
						bat "docker stop dockerdemo"
						bat "docker rmi asramitsinghrawat/dockerdemo:$BUILD_NUMBER"
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