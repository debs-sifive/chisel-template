package gcd

import chisel3._ 
import chisel3.aop._
import chisel3.aop.injecting.InjectingAspect

object GCDAspects {
  def selectGCD(tester: GCD): Seq[GCD] = Seq(tester)

  val inlineLogger = InjectingAspect(
    selectGCD,
    { gcd: GCD =>
      println("hello")
      when (gcd.io.outputValid) {
        printf("The GCD of %d and %d is %d.", gcd.io.value1, gcd.io.value2, gcd.io.outputGCD)
      }
    }
  )

}
