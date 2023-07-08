package ram.talia.moreiotas.common.casting.arithmetic.operator.string

import at.petrak.hexcasting.api.casting.arithmetic.operator.Operator
import at.petrak.hexcasting.api.casting.arithmetic.predicates.IotaMultiPredicate
import at.petrak.hexcasting.api.casting.arithmetic.predicates.IotaPredicate
import at.petrak.hexcasting.api.casting.asActionResult
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.common.lib.hex.HexIotaTypes.*
import ram.talia.moreiotas.api.asActionResult
import ram.talia.moreiotas.common.lib.hex.MoreIotasIotaTypes.STRING
import kotlin.math.roundToInt

object OperatorStringIndex : Operator(2, IotaMultiPredicate.pair(IotaPredicate.ofType(STRING), IotaPredicate.ofType(DOUBLE))) {
    override fun apply(iotas: Iterable<Iota>): Iterable<Iota> {
        val it = iotas.iterator()
        val str = downcast(it.next(), STRING).string
        val index = downcast(it.next(), DOUBLE).double
        return str.getOrNull(index.roundToInt())?.toString()?.asActionResult ?: null.asActionResult
    }
}