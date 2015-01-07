SUMMARY = "Secure parasitic rdate replacement"

DESCRIPTION = "\
tlsdate sets the local clock by securely connecting with TLS to remote \
servers and extracting the remote time out of the secure handshake. Unlike \
ntpdate, tlsdate uses TCP, for instance connecting to a remote HTTPS or TLS \
enabled service, and provides some protection against adversaries that try to \
feed you malicious time information"

HOMEPAGE = "https://github.com/ioerror/tlsdate"
SECTION = "console/network"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=99cc53e1ea4c7781f0160aa3ae25e8b8"
LIBTOOL = "${HOST_SYS}-libtool"
inherit autotools-brokensep

SRC_URI = "git://github.com/ioerror/tlsdate.git"
SRCREV = "fd04f48ed60eb773c8e34d27ef2ee12ee7559a41"

S = "${WORKDIR}/git"

RDEPENDS_${PN} = "openssl libtool"

do_configure() {
	mkdir -p config
	autoreconf --install --verbose --force
	oe_runconf
}

do_qa_configure() {
 mkdir -p fun
}

do_package_qa() {
 mkdir -p fun
}
