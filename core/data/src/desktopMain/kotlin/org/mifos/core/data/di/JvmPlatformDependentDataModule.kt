/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/mobile-wallet/blob/master/LICENSE.md
 */
package org.mifos.core.data.di

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.datetime.TimeZone
import org.mifos.core.data.utils.NetworkMonitor
import org.mifos.core.data.utils.TimeZoneMonitor

class JvmPlatformDependentDataModule : PlatformDependentDataModule {
    override val networkMonitor: NetworkMonitor by lazy {
        object : NetworkMonitor {
            override val isOnline: Flow<Boolean> = flowOf(true)
        }
    }

    override val timeZoneMonitor: TimeZoneMonitor by lazy {
        object : TimeZoneMonitor {
            override val currentTimeZone: Flow<TimeZone> = flowOf(TimeZone.currentSystemDefault())
        }
    }
}