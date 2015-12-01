/* C++ code produced by gperf version 3.0.4 */
/* Command-line: gperf -L C++ -E -t /tmp/n0n1/immersive_mode-generated/KrollGeneratedBindings.gperf  */
/* Computed positions: -k'' */

#line 3 "/tmp/n0n1/immersive_mode-generated/KrollGeneratedBindings.gperf"


#include <string.h>
#include <v8.h>
#include <KrollBindings.h>

#include "com.n0n1.immersive.mode.ImmersiveModeModule.h"
#include "com.n0n1.immersive.mode.ImmersiveViewProxy.h"


#line 14 "/tmp/n0n1/immersive_mode-generated/KrollGeneratedBindings.gperf"
struct titanium::bindings::BindEntry;
/* maximum key range = 2, duplicates = 0 */

class ImmersiveModeBindings
{
private:
  static inline unsigned int hash (const char *str, unsigned int len);
public:
  static struct titanium::bindings::BindEntry *lookupGeneratedInit (const char *str, unsigned int len);
};

inline /*ARGSUSED*/
unsigned int
ImmersiveModeBindings::hash (register const char *str, register unsigned int len)
{
  return len;
}

struct titanium::bindings::BindEntry *
ImmersiveModeBindings::lookupGeneratedInit (register const char *str, register unsigned int len)
{
  enum
    {
      TOTAL_KEYWORDS = 2,
      MIN_WORD_LENGTH = 42,
      MAX_WORD_LENGTH = 43,
      MIN_HASH_VALUE = 42,
      MAX_HASH_VALUE = 43
    };

  static struct titanium::bindings::BindEntry wordlist[] =
    {
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""},
#line 17 "/tmp/n0n1/immersive_mode-generated/KrollGeneratedBindings.gperf"
      {"com.n0n1.immersive.mode.ImmersiveViewProxy", ::com::n0n1::immersive::mode::immersivemode::ImmersiveViewProxy::bindProxy, ::com::n0n1::immersive::mode::immersivemode::ImmersiveViewProxy::dispose},
#line 16 "/tmp/n0n1/immersive_mode-generated/KrollGeneratedBindings.gperf"
      {"com.n0n1.immersive.mode.ImmersiveModeModule", ::com::n0n1::immersive::mode::ImmersiveModeModule::bindProxy, ::com::n0n1::immersive::mode::ImmersiveModeModule::dispose}
    };

  if (len <= MAX_WORD_LENGTH && len >= MIN_WORD_LENGTH)
    {
      register int key = hash (str, len);

      if (key <= MAX_HASH_VALUE && key >= 0)
        {
          register const char *s = wordlist[key].name;

          if (*str == *s && !strcmp (str + 1, s + 1))
            return &wordlist[key];
        }
    }
  return 0;
}
#line 18 "/tmp/n0n1/immersive_mode-generated/KrollGeneratedBindings.gperf"

