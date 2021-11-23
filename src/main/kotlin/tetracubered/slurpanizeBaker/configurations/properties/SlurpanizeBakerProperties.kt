package tetracubered.slurpanizeBaker.configurations.properties

import io.smallrye.config.ConfigMapping

@ConfigMapping(prefix = "slurpanize-baker")
interface SlurpanizeBakerProperties {

    fun security(): SecurityProperties

}