package tetracubered.slurpanizeBaker.configurations.properties

interface SecurityProperties {

    fun adminUsername(): String
    fun adminPassword(): String
    fun jwtIssuer(): String

}
