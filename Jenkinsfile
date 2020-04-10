pipeline
{
	

	environment 
	{
		registry = 'asramitsinghrawat/dockerdemo'
		registryCredential = 'docker-hub'
		def notify(status)
		{
		emailext body: '''${STATUS} : Job \'${env.JOB_NAME}[${env.BUILD_NUMBER}]\'
Check console output at <a href=\'${env.BUILD_URL}\'>${env.JOB_NAME}[${env.BUILD_NUMBER}]</a>''', subject: '${STATUS} : Job \'${env.JOB_NAME}[${env.BUILD_NUMBER}]\'', to: 'asr.amitsinghrawat@gmail.com'
		}
	}
	
	agent any
	
	try
	{
		stages
		{	
			notify('started')
			
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
					bat "docker rmi asramitsinghrawat/dockerdemo:$BUILD_NUMBER"
				}
			}	
			notify('succeded')
		
		}
	}catch(err){ 
		notify('error ${err}')
		CurrentBuild.result='Failure'
	}
}