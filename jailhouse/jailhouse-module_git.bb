require jailhouse.inc

SUMMARY = "Jailhouse is a partitioning Hypervisor based on Linux"

inherit module

EXTRA_OEMAKE='SRCARCH="${ARCH}" KERNELDIR="${STAGING_KERNEL_DIR}" PREFIX="${D}"'

do_install_append() {
        install -d  ${D}/usr/share/jailhouse/
        install -d  ${D}/lib/firmware/
        cp hypervisor/jailhouse.bin ${D}/lib/firmware/
        cp -r configs/*.cell ${D}/usr/share/jailhouse/
}

FILES_${PN} += "/lib/firmware/*"
FILES_${PN} += "/usr/share/jailhouse/*"

KERNEL_MODULE_AUTOLOAD += "jailhouse"
COMPATIBLE_HOST = '(x86_64.*)-(linux)'
