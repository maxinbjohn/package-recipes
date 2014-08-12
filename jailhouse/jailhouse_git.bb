require jailhouse.inc

SUMMARY = "Jailhouse is a partitioning Hypervisor based on Linux"

EXTRA_OEMAKE = " -I../hypervisor/include \
                 CROSS_COMPILE=${TARGET_PREFIX} \
               "

do_compile () {
	cd tools
	oe_runmake
}

do_install () {
        install -d ${D}${base_sbindir}
        install -m 0755 tools/jailhouse ${D}${base_sbindir}/
}

BBCLASSEXTEND = "native nativesdk"
