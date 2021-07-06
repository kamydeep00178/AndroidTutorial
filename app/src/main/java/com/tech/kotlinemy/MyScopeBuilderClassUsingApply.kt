package com.tech.kotlinemy

data class MyScopeBuilderClassUsingApply(
     var name : String ="",
     var age : String ="",
     var rollNo : String=""
)
{
    fun name(nameNow : String) : MyScopeBuilderClassUsingApply = apply {
        name = nameNow
    }
    fun age(ageNow : String) : MyScopeBuilderClassUsingApply = apply {
        age = ageNow
    }
    fun rollNo(rollNoNow : String) : MyScopeBuilderClassUsingApply = apply {
        rollNo = rollNoNow
    }
}