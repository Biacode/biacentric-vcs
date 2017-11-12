package com.biacode.biacentric.vcs.git.logmessage

import com.biacode.biacentric.vcs.commons.Assertions

/**
 * Created by Arthur Asatryan.
 * Date: 11/11/17
 * Time: 4:29 PM
 */
class GitLogMessageJsonFormatBuilder {

    //region Properties
    private var template: GitLogMessageTemplate
    //endregion

    //region Constructors
    init {
        this.template = GitLogMessageTemplate()
    }
    //endregion

    //region Public methods
    fun fromTemplate(template: GitLogMessageTemplate): GitLogMessageJsonFormatBuilder {
        Assertions.assertNotEmpty(template.placeholders, "The set of placeholders should not be null")
        this.template = template
        return this
    }

    fun build(): String {
        val jsonFormatBuilder = StringBuilder()
        jsonFormatBuilder.append("{")
        template.placeholders.forEach {
            jsonFormatBuilder.append("""|"${it.propertyName}": "${it.placeholder}", """.trimMargin())
        }
        return StringBuilder(jsonFormatBuilder.dropLast(2)).append("},").toString()
    }
    //endregion
}