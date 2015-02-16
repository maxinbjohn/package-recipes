SUMMARY = "American fuzzy lop is a security-oriented fuzzer that employs \
a novel type of compile-time instrumentation and genetic algorithms to \
automatically discover clean, interesting test cases that trigger new \
internal states in the targeted binary. "

SECTION = "security"
HOMEPAGE = "http://lcamtuf.coredump.cx/afl/"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://docs/COPYING;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "http://lcamtuf.coredump.cx/afl/releases/afl-latest.tgz \
           file://makefile_build.patch \
          "

SRC_URI[md5sum] = "a6eb6317b8458187eef4937cbaf5183d"
SRC_URI[sha256sum] = "9e49445578b85ef220766d4914e71a4af877dc177a6b050bbc16d491f8b671cb"

inherit autotools-brokensep

do_install () {
    install -d ${D}${sbindir}
    rm -f ${D}${sbindir}/afl-plot.sh
    install -m 755 afl-gcc afl-fuzz afl-showmap afl-plot afl-tmin afl-cmin afl-gotcpu afl-whatsup ${D}${sbindir}
    install -m 755 afl-as ${D}${sbindir}
}

BBCLASSEXTEND += "native"
