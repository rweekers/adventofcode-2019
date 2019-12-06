package adventofcode

class IntCode(private val initialList: List<Int>, var parameter: Int = 1) {

    private var inputList = mutableListOf<Int>()
    var output = mutableListOf<Int>()

    fun runProgram(parameter: Int = 1): Int {
        this.parameter = parameter
        inputList = initialList.toMutableList()
        var currentIndex = 0
        do {
            currentIndex += processInstruction(inputList, currentIndex)
        } while (inputList[currentIndex] != 99)
        return output.last()
    }

    private fun processInstruction(inputList: MutableList<Int>, currentIndex: Int): Int {
        val instruction = inputList[currentIndex]
        val code = instruction.toString().takeLast(2).toInt()

        val parameterModes = if (listOf(1, 2, 5, 6, 7, 8).contains(code) && instruction.toString().length > 1) {
            instruction.dropLastN(2)
        } else {
            0
        }

        when (code) {
            1 -> return MemCodeAddition(parameterModes, listOf(inputList[currentIndex + 1], inputList[currentIndex + 2], inputList[currentIndex + 3]), inputList).process()
            2 -> return MemCodeMultiply(parameterModes, listOf(inputList[currentIndex + 1], inputList[currentIndex + 2], inputList[currentIndex + 3]), inputList).process()
            3 -> return MemCodeInput(parameter, inputList[currentIndex + 1], inputList).process()
            4 -> return MemCodeOutput(parameter, inputList[currentIndex + 1], inputList, output).process()
            5 -> return MemCodeJump(parameterModes, listOf(inputList[currentIndex + 1], inputList[currentIndex + 2]), inputList, true, currentIndex).process()
            6 -> return MemCodeJump(parameterModes, listOf(inputList[currentIndex + 1], inputList[currentIndex + 2]), inputList, false, currentIndex).process()
            7 -> return MemCodeLessThan(parameterModes, listOf(inputList[currentIndex + 1], inputList[currentIndex + 2], inputList[currentIndex + 3]), inputList).process()
            8 -> return MemCodeEquals(parameterModes, listOf(inputList[currentIndex + 1], inputList[currentIndex + 2], inputList[currentIndex + 3]), inputList).process()
            99 -> return 1
        }

        return -1
    }

    private interface MemCodeIns {
        fun process(): Int
    }

    private abstract class MemCodeOperation(val parameterModes: Int, val parameters: List<Int>, val inputList: MutableList<Int>) : MemCodeIns {

        fun getParameterValue(postion: Int): Int {
            val mode = parameterModes.parameterMode(postion)
            val parameterValue = parameters[postion]

            return if (mode == 1) {
                parameterValue
            } else {
                inputList[parameterValue]
            }
        }
    }

    private class MemCodeMultiply(parameterModes: Int, parameters: List<Int>, inputList: MutableList<Int>) : MemCodeOperation(parameterModes, parameters, inputList) {

        override fun process(): Int {
            val calculatedValue = getParameterValue(0).times(getParameterValue(1))
            inputList[parameters[2]] = calculatedValue
            return 4
        }
    }

    private class MemCodeAddition(parameterModes: Int, parameters: List<Int>, inputList: MutableList<Int>) : MemCodeOperation(parameterModes, parameters, inputList) {

        override fun process(): Int {
            val calculatedValue = getParameterValue(0).plus(getParameterValue(1))
            inputList[parameters[2]] = calculatedValue
            return 4
        }
    }

    private class MemCodeLessThan(parameterModes: Int, parameters: List<Int>, inputList: MutableList<Int>) : MemCodeOperation(parameterModes, parameters, inputList) {

        override fun process(): Int {
            if (getParameterValue(0) < getParameterValue(1)) {
                inputList[parameters[2]] = 1
            } else {
                inputList[parameters[2]] = 0
            }
            return 4
        }
    }

    private class MemCodeEquals(parameterModes: Int, parameters: List<Int>, inputList: MutableList<Int>) : MemCodeOperation(parameterModes, parameters, inputList) {

        override fun process(): Int {
            if (getParameterValue(0) == getParameterValue(1)) {
                inputList[parameters[2]] = 1
            } else {
                inputList[parameters[2]] = 0
            }
            return 4
        }
    }

    private class MemCodeJump(parameterModes: Int, parameters: List<Int>, inputList: MutableList<Int>, private val jumpIfTrue: Boolean, private val index: Int) : MemCodeOperation(parameterModes, parameters, inputList) {
        override fun process(): Int {
            val parameterOne = getParameterValue(0)
            val parameterTwo = getParameterValue(1)

            if ((jumpIfTrue && parameterOne != 0) || (!jumpIfTrue && parameterOne == 0)) {
                return parameterTwo - index
            }
            return 3
        }
    }

    private class MemCodeInput(private val parameter: Int, private val parameterValue: Int, private val inputList: MutableList<Int>) : MemCodeIns {
        override fun process(): Int {
            inputList[parameterValue] = parameter
            return 2
        }
    }

    private class MemCodeOutput(private var parameter: Int, private val parameterValue: Int, private val inputList: MutableList<Int>, private val output: MutableList<Int>) : MemCodeIns {
        override fun process(): Int {
            parameter = inputList[parameterValue]
            output.add(inputList[parameterValue])
            return 2
        }
    }
}