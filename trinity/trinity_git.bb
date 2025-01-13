SUMMARY = "a Linux System call fuzz tester"
DESCRIPTION = "Trinity, a Linux System call fuzz tester."
HOMEPAGE = "http://codemonkey.org.uk/projects/trinity/"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=96094d47cfbd2cc45eb46ce0fc423c04"

COMPATIBLE_HOST = "(x86_64|arm|aarch64).*-linux"

PV = "1.5"
SRCREV = "ba2360ed84a8c521d9c34af9c909315ea7c62aad"
SRC_URI = "git://github.com/kernelslacker/trinity.git;protocol=https;nobranch=1 \
          "

S = "${WORKDIR}/git"

inherit useradd

USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} = "--system --create-home --shell /bin/sh ${PN} "

do_configure () {
    ./configure
}