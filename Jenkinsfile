node {
	stage ('SCM checkout'){
		git "https://github.com/PavelBartBy/SkillUpUiTest"
		}
	stage ('PavelBartBy'){
    	dir("PavelBartBy") {
	   sh "mvn clean install"
       }
       	dir("PavelBartBy/target") {
	   sh "java -jar target/PBart_TestUIP-1.0-SNAPSHOT.jar"
       }
		}
}
