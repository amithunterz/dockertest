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
		
		stage('Building image') 
		{
			steps{
				script {
					dockerImage = docker.build registry + ":$BUILD_NUMBER"
				}
			}
		}

		
		stage('Deploy Image') 
		{
			steps{
				script {
					docker.withRegistry( '', registryCredential ) {
						dockerImage.push()
						}
				}
			}
		}
		
		stage('Remove Unused docker image') 
		{
			steps{
				bat "docker rmi $registry:$BUILD_NUMBER"
			}
		}
	}
}
		
		
		
		

		stage('docker push')
		{
			steps
			{
				withDockerRegistry(credentialsId: registryCredential, url: 'https://registry.hub.docker.com'){
				
				bat 'docker push asramitsinghrawat/dockerdemo'
				
				}
			}
		}
	}
}