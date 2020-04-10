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
						notify('started')
						bat "docker run -d --rm -p 8087:8080 --name dockerdemo asramitsinghrawat/dockerdemo:27"						
					}
				}
				
				
				stage('docker stop and remove image') 
				{
					notify('Paused')
					input {
						message "Proceed to stop the container and remove image"
						ok "Yes, Stop it"
					}
					
					steps
					{
						bat "docker stop dockerdemo"
						bat "docker rmi asramitsinghrawat/dockerdemo:27"
					}
				}
	}

	post
	{
		success
		{
			notify('succeded')
		}
		failure
		{
			notify('error')
		}
	}


}

def notify(status)
{
emailext body: '''${STATUS} : Job \'${env.JOB_NAME}[${env.BUILD_NUMBER}]\'
Check console output at <a href=\'${env.BUILD_URL}\'>${env.JOB_NAME}[${env.BUILD_NUMBER}]</a>''', subject: '${STATUS} : Job \'${env.JOB_NAME}[${env.BUILD_NUMBER}]\'', to: 'asr.amitsinghrawat@gmail.com'
}